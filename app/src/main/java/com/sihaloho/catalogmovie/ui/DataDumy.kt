package com.sihaloho.catalogmovie.ui

import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity

object DataDumy {

    fun dataMovie(): List<MovieEntity> {
        val movie = ArrayList<MovieEntity>()
        movie.add(
            MovieEntity(
                "1",
                "A Star Is Born",
                "7.5",
                12f,
                "10/03/2018",
                " Drama, Romance, Music ",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            )
        )
        movie.add(
            MovieEntity(
                "2",
                "Aquaman",
                "6.9",
                12f,
                "12/21/2018 ",
                " Action, Adventure, Fantasy ",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
            )
        )
        movie.add(
            MovieEntity(
                "3",
                "Bohemian",
                "8.0",
                12f,
                "11/02/2018",
                "Drama, Music",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
        )
        movie.add(
            MovieEntity(
                "4",
                "Creed II",
                "6.9",
                12f,
                "11/21/2018",
                "Drama",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
            )
        )
        movie.add(
            MovieEntity(
                "5",
                "Glass",
                "6.6",
                12f,
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            )
        )
        movie.add(
            MovieEntity(
                "6",
                "Infinity War",
                "8.3",
                12f,
                "04/27/2018",
                " Adventure, Action, Science Fiction",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )

        movie.add(
            MovieEntity(
                "7",
                "Master Z: Ip Man Legacy",
                "5.6",
                12f,
                "12/26/2018",
                "Action",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."
            )
        )

        movie.add(
            MovieEntity(
                "8",
                "Mortal Engines",
                "6.1",
                12f,
                "12/14/2018",
                " Adventure, Fantasy ",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
            )
        )

        movie.add(
            MovieEntity(
                "9",
                "Robin Hood",
                "5.9",
                12f,
                "11/21/2018",
                "Adventure, Action, Thriller",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
            )
        )

        movie.add(
            MovieEntity(
                "10",
                "Spider-Man: Into the Spider-Verse",
                "8.4",
                12f,
                "12/14/2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
            )
        )

        return movie
    }

    fun dataTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "1",
                "Arrow",
                5.8f,
                "R.drawable.poster_arrow",
                "October 10, 2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
            )
        )
        tvShow.add(
            TvShowEntity(
                "2",
                "The Flash",
                6.7f,
                "R.drawable.poster_flash",
                "October 7, 2014",
                "Drama, Sci-Fi & Fantasy",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
            )
        )
        tvShow.add(
            TvShowEntity(
                "3",
                "Game of Thrones",
                8.1f,
                "R.drawable.poster_god",
                "April 17, 2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                "leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
            )
        )
        tvShow.add(
            TvShowEntity(
                "4",
                "Gotham",
                7.4f,
                "R.drawable.poster_gotham",
                "September 22, 2014",
                "Drama, Fantasy, Crime",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"
            )
        )

        tvShow.add(
            TvShowEntity(
                "5",
                "Marvel's Iron Fist",
                6.5f,
                "R.drawable.poster_iron_fist",
                "March 17, 2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
            )
        )
        tvShow.add(
            TvShowEntity(
                "6",
                "NCIS",
                7.1f,
                "R.drawable.poster_ncis",
                "September 23, 2003",
                "Action & Adventure, Crime, Drama",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position."
            )
        )
        tvShow.add(
            TvShowEntity(
                "7",
                "Riverdale",
                8.6f,
                "R.drawable.poster_riverdale",
                "January 26, 2017",
                "Drama, Mystery",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
            )
        )

        tvShow.add(
            TvShowEntity(
                "8",
                "Supergirl",
                7.1F,
                "R.drawable.poster_supergirl",
                "October 26, 2015",
                "Action, Adventure, Drama, Science Fiction",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
            )
        )
        tvShow.add(
            TvShowEntity(
                "9",
                "Supernatural",
                8.1F,
                "R.drawable.poster_supernatural",
                "September 13, 2005",
                "Drama, Mystery, Sci-Fi & Fantasy ",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way."
            )
        )

        tvShow.add(
            TvShowEntity(
                "10",
                "The Walking Dead",
                7.9F,
                " R.drawable.poster_the_walking_dead",
                "October 31, 2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
            )
        )

        return tvShow
    }

}