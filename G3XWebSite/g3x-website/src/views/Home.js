import Card from "../components/Card";
import Header from "../components/Header";
import '../style/Home.css'

function Home() {

  const events = [
    {
      title: "G3xPo 2025",
      description: "Our yearly project presentation for public in unesp campus (happend by may 2025",
      image: "/images/gexpo2025.JPG"
    },
    {
      title: "G3xPo 2026",
      description: "Coming soon...",
      image: "/images/gexpo_logo.svg",
    },
    {
      title: "Cafe GameJam",
      description: "Game jam organized by g3x yearly",
      image: "/images/gexpo_logo.jpg",
    }
  ]

  const handleCardClick = (eventTitle) => {
    alert(`You clicked on ${eventTitle}`);
  }

  return (
    <div>
      <Header />
      <main>
        <h1>Welcome to my first react project! The G3X website</h1>
        <p>Here im gonna put g3x projects and events</p>

        <h2>Events</h2>

        <div className="card-container">
          {events.map(event => (
            <Card 
              image={event.image}
              title={event.title}
              description={event.description}
              onClick={() => handleCardClick(event.title)}
            />
          ))}
        </div>

        


        <h2>Projects</h2>

        <h2>Who we are</h2>
      </main>
    </div>
    

  )
}

export default Home;