import React from "react";
import "../style/Card.css";

function Card({ title, description, image, onClick }) {
  return (
    <div className="card" onClick={onClick}>
      <img className="card-image" src={image} alt={title} />
      <h3 className="card-title">{title}</h3>
      <p className="card-description">{description}</p>
    </div>
  );
}

export default Card;
