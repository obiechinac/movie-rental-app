# movie-rental-app
The project is to design and build well-functioned endpoints for a video rental company that
displays a list of available movies from a database and calculates video rental fees for a movie
selected from the list. The candidate is responsible for developing the REST endpoints, the
business logic (the application layer), and the database for storing and retrieving the video
information.
The application has the following requirements:
1. Data
The application data consists of storing videos and some information about them as follows:
1) All videos have the following information:
● Video Title
● Video Type (Regular, Children’s Movie, New Release)
● Video Genre (Action, Drama, Romance, Comedy, Horror)
2) The following video types have the following additional properties:
● Children’s Movie: Maximum Age
● New Release: Year Released
2. Video List Endpoint
The video list Endpoint should list the videos from the database. The List should be paginated.
Upon selecting the video to rent, the system should take the user to the video price. The video
list endpoint should display a list of videos ret
3. Calculate Price Endpoint.
The Calculate video price endpoint for a user should have the following request field:
● The name of the user.
● The title of the video selected
● The number of days the user chose to rent the video for
This price should be calculated differently for each video type using a video type rate and the
number of days for rental. The following rates can be assumed:
● Regular: 10 Birr /day
● Children’s Movie: 8 Birr / Day
● New Release: 15 Birr / Day
The calculation for each type is as follows:
● Regular: rate × days
● Children’s movie: rate × days + maximumAge / 2
● New Release: rate * days - years of releasedeved from a database. The list should show at
least 5 videos with the following information for each video.
● Video Title
● Video Type (one of Regular, Children’s Movie, New Release)
● Video Genre (one of Action, Drama, Romance, Comedy, Horror)
