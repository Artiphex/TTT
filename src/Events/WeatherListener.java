package Events;

import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

}
