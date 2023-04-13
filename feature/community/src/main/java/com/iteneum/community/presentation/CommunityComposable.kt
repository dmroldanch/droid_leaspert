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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iteneum.community.R
import com.iteneum.community.data.CommunityViewModel
import com.iteneum.community.domain.CardMenuItem
import com.iteneum.designsystem.components.LpIconTextCard
import com.iteneum.designsystem.theme.LeasePertTheme

@Composable
fun CommunityUI(viewModel: CommunityViewModel = viewModel()) {
    val width = LeasePertTheme.sizes.extraSize124
    val height = LeasePertTheme.sizes.extraSize128
    val padding10 = LeasePertTheme.sizes.midSmallSize
    val padding20 = LeasePertTheme.sizes.minorRegularSize

    val cards = remember { viewModel.buttonCards }
    Column(modifier = Modifier.fillMaxWidth()) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = padding20, start = padding10, end = padding10)
    ) {

        Text(
            text = "Community",
            modifier = Modifier.padding(start = 15.dp),
            style = MaterialTheme.typography.titleMedium,
        )
        // ...
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)
        ) {
            items(cards) { cardButton ->
                LpIconTextCard(modifier = Modifier.size(width = width, height = height),
                    //modifier=Modifier.width(widthdp).height(heightdp),
                    icon = cardButton.icon, description = stringResource(
                        id = when (cardButton.cardName) {
                            CardMenuItem.AMENITIES -> R.string.amenities
                            CardMenuItem.EVENTS -> R.string.events
                            CardMenuItem.COMMUNITY_WALL -> R.string.communityWall
                            CardMenuItem.DOITYOURSELF -> R.string.doItYourself
                            CardMenuItem.SERVICES -> R.string.services
                        }
                    ), onCardClick = { viewModel.onItemClick(cardButton) })
            }
        }
    }
}
