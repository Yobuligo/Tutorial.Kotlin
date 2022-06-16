interface IMaterial

interface IPartsList

interface IBlueprint<TPartsList : IPartsList> {
    val partsList: TPartsList
}

interface IProduct<TPartsList : IPartsList, TBluePrint : IBlueprint<TPartsList>> {
    val blueprint: TBluePrint
}

fun main() {

}