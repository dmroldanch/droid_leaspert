import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iteneum.community.R
import com.iteneum.community.data.CommunityViewModel
import com.iteneum.community.domain.CardMenuItem
import com.iteneum.designsystem.components.LpIconTextCard
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * This function creates a password OutlinedTextField
 * @param viewModel receives a viewModel to manage the logic of the view
 *this view model is used to handle the loading of the components of the interface
 * including icons, text and button click functionality.
 *
 * @author Andrés Ivan Medina Herrera
 */
@Composable
fun CommunityUI(viewModel: CommunityViewModel = viewModel()) {
    val cardWith = LeasePertTheme.sizes.extraSize124
    val cardHeight = LeasePertTheme.sizes.extraSize128
    val cardPadding8 = LeasePertTheme.sizes.smallerSize
    val cardPadding15 = LeasePertTheme.sizes.smallSize
    val cardPadding10 = LeasePertTheme.sizes.midSmallSize
    val cardPadding20 = LeasePertTheme.sizes.minorRegularSize
    val communityCardButtons = remember { viewModel.communityServicesbuttonCards }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = cardPadding20, start = cardPadding10, end = cardPadding10)
    ) {
        Text(
            text = "Community",
            modifier = Modifier.padding(start = cardPadding15),
            style = MaterialTheme.typography.titleMedium,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(cardPadding8)
        ) {
            items(communityCardButtons) { singleCommunityCardButton ->
                LpIconTextCard(modifier = Modifier.size(width = cardWith, height = cardHeight),
                    icon = singleCommunityCardButton.icon,
                    description = stringResource(
                        id = when (singleCommunityCardButton.cardName) {
                            CardMenuItem.AMENITIES -> R.string.communityui_cardbutton_ammenities
                            CardMenuItem.EVENTS -> R.string.communityui_cardbutton_events
                            CardMenuItem.COMMUNITY_WALL -> R.string.communityui_cardbutton_communityWall
                            CardMenuItem.DOITYOURSELF -> R.string.communityui_cardbutton_doItYourself
                            CardMenuItem.SERVICES -> R.string.communityui_cardbutton_services
                        }
                    ),
                    onCardClick = { viewModel.onItemClick(singleCommunityCardButton) })
            }
        }
    }
}
