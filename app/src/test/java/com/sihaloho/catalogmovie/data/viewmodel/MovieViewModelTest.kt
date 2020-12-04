
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.sihaloho.catalogmovie.data.FakeCatalogRepository
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.repository.CatalogRepository
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.ui.DataDumy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel



    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup(){
        viewModel = MovieViewModel(catalogRepository)
    }

    @Test
    fun getMovies() {
        val dummyCourses = DataDumy.dataMovie()
        val courses = MutableLiveData<List<MovieEntity>>()
        courses.value = dummyCourses

        `when`(catalogRepository.getMovies()).thenReturn(courses)
        val courseEntities = viewModel.getMovies().value
        verify(catalogRepository).getMovies()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }


}