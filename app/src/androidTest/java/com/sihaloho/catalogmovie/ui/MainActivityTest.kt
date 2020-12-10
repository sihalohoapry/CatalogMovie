package com.sihaloho.catalogmovie.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.ui.activity.MainActivity
import com.sihaloho.catalogmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {


    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {

        //movie
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        //tvshow
        Espresso.onView(withId(R.id.rv_tvShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        //favorite movie
        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Movie"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Movie")).perform(click())
        Espresso.onView(withId(R.id.rv_movie_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())


        //favorite tv show

        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())

        Espresso.onView(withId(R.id.rv_tv_show_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

        //delete favorite
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        //check favorite
        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

    }
}