import { useEffect } from "react";
import MapView from "../../components/map/MapView";
import useBusLocationStore from "../../store/busLocationStore";

export default function LiveTracking() {
  const { buses, updateBusLocation } = useBusLocationStore();

  // Simulate movement every 2 seconds
  useEffect(() => {
    const interval = setInterval(() => {
      buses.forEach((bus) => {
        const newLat = bus.lat + (Math.random() - 0.5) * 0.001;
        const newLng = bus.lng + (Math.random() - 0.5) * 0.001;
        const newSpeed = Math.floor(Math.random() * 60);

        updateBusLocation(bus.id, newLat, newLng, newSpeed);
      });
    }, 2000);

    return () => clearInterval(interval);
  }, [buses, updateBusLocation]);

  return (
    <div>
      <h1 className="text-2xl font-bold mb-4">Live Bus Tracking</h1>
      <MapView buses={buses} />
    </div>
  );
}
