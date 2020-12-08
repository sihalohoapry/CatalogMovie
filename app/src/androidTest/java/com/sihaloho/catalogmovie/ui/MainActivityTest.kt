package com.sihaloho.catalogmovie.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
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
import org.junit.Rule
import org.junit.Test

class MainActivityTest {


    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {

        //movie
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Thread.sleep(1000)

        //tvshow
        Espresso.onView(withId(R.id.rv_tvShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())
        Thread.sleep(1000)

        //favorite movie
        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Movie"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Movie")).perform(click())
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Thread.sleep(1000)


        //favorite tv show

        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_tv_show_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

        //delete favorite
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        Thread.sleep(1000)
        Espresso.onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.fab_love)).perform(click())
        Thread.sleep(1000)
        Espresso.onView(withId(R.id.iv_arrow_left)).perform(click())

        //check favorite
        Thread.sleep(1000)
        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Thread.sleep(1000)

        openActionBarOverflowOrOptionsMenu(activityRule.getActivity());
        Espresso.onView(withText("Favorite Tv Show"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withText("Favorite Tv Show")).perform(click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Thread.sleep(1000)

    }
}