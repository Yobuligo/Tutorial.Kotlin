// Event
interface IEvent<TEventSender> {
    val eventSender: TEventSender
    val event: String
}

interface IEventHandler<TEventSender, TEvent : IEvent<TEventSender>> {
    fun onEvent(event: TEvent)
}

// Component
interface IComponentEvent<TEventSender> : IEvent<TEventSender>

interface IComponentEventHandler<TEventSender, TEvent : IComponentEvent<TEventSender>> :
    IEventHandler<TEventSender, TEvent>

interface IComponent<TEventSender, TEvent : IComponentEvent<TEventSender>> {
    val name: String
    val children: List<IComponent<*, *>>
    fun addChild(component: IComponent<*, *>)
    fun registerOnChange(eventHandler: IComponentEventHandler<TEventSender, TEvent>): IComponent<TEventSender, TEvent>
}

abstract class Component<TEventSender, TEvent : IComponentEvent<TEventSender>> : IComponent<TEventSender, TEvent> {
    private val _children = mutableListOf<IComponent<*, *>>()
    private val eventHandlers = mutableListOf<IComponentEventHandler<TEventSender, TEvent>>()

    override val name: String = "ContainerComponent"
    override val children: List<IComponent<*, *>>
        get() {
            return _children
        }

    override fun addChild(component: IComponent<*, *>) {
        _children.add(component)
    }

    override fun registerOnChange(eventHandler: IComponentEventHandler<TEventSender, TEvent>): IComponent<TEventSender, TEvent> {
        eventHandlers.add(eventHandler)
        return this
    }

    fun raiseChanged() {
        val event = createChangedEvent()
        eventHandlers.forEach { eventHandler ->
            eventHandler.onEvent(event)
        }
    }

    protected abstract fun createChangedEvent(): TEvent
}

// Button
interface IButtonEvent : IComponentEvent<IButton>

interface IButtonEventHandler : IComponentEventHandler<IButton, IButtonEvent>

interface IButton : IComponent<IButton, IButtonEvent> {
    val caption: String
    fun registerOnClick(eventHandler: IButtonEventHandler)
}

class ButtonEvent(override val eventSender: IButton, override val event: String) : IButtonEvent

class Button(override val caption: String) : IButton, Component<IButton, IButtonEvent>() {
    private val eventHandlers = mutableListOf<IButtonEventHandler>()

    override fun registerOnClick(eventHandler: IButtonEventHandler) {
        eventHandlers.add(eventHandler)
    }

    fun raiseClicked() {
        val buttonEvent = ButtonEvent(this, "clicked")
        eventHandlers.forEach { eventHandler ->
            eventHandler.onEvent(buttonEvent)
        }
    }

    override fun createChangedEvent(): IButtonEvent {
        return ButtonEvent(this, "changed")
    }
}

// Table
interface ITableEvent : IComponentEvent<ITable>

interface ITableEventHandler : IComponentEventHandler<ITable, ITableEvent>

interface ITable : IComponent<ITable, ITableEvent> {
    fun registerOnRowClicked(eventHandler: ITableEventHandler)
}

// EventHandler
class EventHandler : IButtonEventHandler {
    override fun onEvent(event: IButtonEvent) {
        println("Button '${event.eventSender.caption}' was '${event.event}'.")
    }
}

fun main() {
    val button = Button("Click Me")
    button.registerOnClick(EventHandler())
    button.registerOnChange(EventHandler())
    button.raiseClicked()
}