package models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse(
    @SerialName("products")
    var list: List<Products>
)
@Serializable
data class Products (
    @SerialName("id")
    var id: Int=0,
    @SerialName("title")
    var title: String="",
    @SerialName("description")
    val description: String="",
    @SerialName("price")
    val price: Double=0.0,
    @SerialName("discountPercentage")
    val discountPercentage: Double=0.0,
    @SerialName("category")
    val category: String="",
    @SerialName("thumbnail")
    val thumbnail: String="",
)