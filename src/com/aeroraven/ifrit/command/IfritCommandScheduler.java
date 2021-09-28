package com.aeroraven.ifrit.command;

import java.util.*;

import com.aeroraven.ifrit.exception.IfritCommandException;

public class IfritCommandScheduler {
	protected final Queue<IfritCommandBase> cmdQueue;
	public IfritCommandScheduler() {
		cmdQueue = new LinkedList<IfritCommandBase>();
	}
	public synchronized void addCommand(IfritCommandBase cmd) {
		cmdQueue.offer(cmd);
	}
	public synchronized void executeCommand(Object ...objects) throws IfritCommandException {
		IfritCommandBase cmd = cmdQueue.peek();
		cmdQueue.poll();
		cmd.execute(objects);
	}
}
