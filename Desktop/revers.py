def reversString(w):
	wl = list(w)
	l = len(wl)
	last = l-1
	for i in xrange(l/2):
		temp = wl[i]
		wl[i] = wl[last - i]
		wl[last - i] = temp

	print ''.join(wl)

## testing
reversString("Madam, I'm Adam")