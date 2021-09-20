package com.aeroraven.ifrit.command;

import java.util.*;

public class IfritCommandScheduler {
	protected Queue<IfritCommandBase> cmdQueue;
	public IfritCommandScheduler() {
		cmdQueue = new LinkedList<IfritCommandBase>();
	}
	public synchronized void addCommand(IfritCommandBase cmd) {
		cmdQueue.offer(cmd);
	}
	public synchronized void executeCommand(Object ...objects) {
		IfritCommandBase cmd = cmdQueue.peek();
		cmdQueue.poll();
		cmd.execute(objects);
	}
}
