import numpy as np
import matplotlib
matplotlib.use('Qt5Agg')
import matplotlib.pyplot as plt 

# Load the data from the file
data = np.loadtxt('data/COUNTS/Data2.txt')

# Split the data into separate arrays
V = data[:, 0]
E = data[:, 1]
Vcount = data[:, 2]
Ecount = data[:, 3]
PQ_count = data[:, 4]
ELOGV = data[:, 5]
Operations = data[:, 6]

# Create a figure and set the title
fig, ax = plt.subplots()
ax.set_title('ELOGV AND OPERATIONS')
fig, bx =plt.subplots()

bx.set_title("Relation between E and Operations")

fig, vx =plt.subplots()
vx.set_title("Relation between V and Operations")

fig, mx =plt.subplots()
mx.set_title("Relation between PQ_count and Operations")

# Plot each column of data

ax.plot(ELOGV, label='ELOGV')
ax.plot(Operations, label='Operations')

bx.plot(ELOGV, label='Operations')
bx.plot(E, label='Edges')

vx.plot(ELOGV, label='Operations')
vx.plot(V, label='Vertices')

mx.plot(ELOGV, label='Operations')
mx.plot(PQ_count, label='Priority Queue')



# Add legend and axis labels
ax.legend()
ax.set_xlabel('EXPERIMENT NUMBER')
ax.set_ylabel('MAGNITUDE')

bx.legend()
bx.set_xlabel('EXPERIMENT NUMBER')
bx.set_ylabel('MAGNITUDE')

vx.legend()
vx.set_xlabel('EXPERIMENT NUMBER')
vx.set_ylabel('MAGNITUDE')

mx.legend()
mx.set_xlabel('EXPERIMENT NUMBER')
mx.set_ylabel('MAGNITUDE')


# Show the plot
plt.show()
