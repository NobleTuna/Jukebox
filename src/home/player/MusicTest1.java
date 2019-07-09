package home.player;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {
	
	public void play() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("sequencer is ready!");
		} catch (MidiUnavailableException e) {
			
			System.out.println("sequencer problem" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
		
	}

}
