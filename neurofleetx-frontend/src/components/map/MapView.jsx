import { useEffect, useRef } from "react";
import mapboxgl from "mapbox-gl";

mapboxgl.accessToken = import.meta.env.VITE_MAPBOX_KEY;

export default function MapView({ buses = [] }) {
  const mapContainer = useRef(null);
  const map = useRef(null);

  useEffect(() => {
    if (map.current) return; // Prevent reinitializing map

    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: "mapbox://styles/mapbox/streets-v12",
      center: [73.8567, 18.5204], // Pune (default)
      zoom: 11,
    });
  }, []);

  // Add markers on buses change
  useEffect(() => {
    if (!map.current) return;

    buses.forEach((bus) => {
      const el = document.createElement("div");
      el.className = "bus-marker";
      el.style.width = "20px";
      el.style.height = "20px";
      el.style.background = "red";
      el.style.borderRadius = "50%";
      el.style.border = "2px solid white";

      new mapboxgl.Marker(el)
        .setLngLat([bus.lng, bus.lat])
        .setPopup(
          new mapboxgl.Popup().setHTML(`
            <strong>Bus: ${bus.number}</strong><br/>
            Driver: ${bus.driver}<br/>
            Speed: ${bus.speed} km/h
          `)
        )
        .addTo(map.current);
    });
  }, [buses]);

  return (
    <div className="w-full h-[600px] rounded-lg overflow-hidden shadow-lg">
      <div ref={mapContainer} className="w-full h-full" />
    </div>
  );
}
