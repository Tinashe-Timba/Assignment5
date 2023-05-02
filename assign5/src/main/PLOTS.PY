import numpy as np
import matplotlib
matplotlib.use('Qt5Agg')
import matplotlib.pyplot as plt 

# Load the data from the file
data = np.loadtxt('Data1.txt')

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
ax.set_title('Data from file')

# Plot each column of data

ax.plot(ELOGV, label='ELOGV')
ax.plot(Operations, label='Operations')


# Add legend and axis labels
ax.legend()
ax.set_xlabel('Index')
ax.set_ylabel('Value')

# Show the plot
plt.show()
