var Animal = { name: "Animal" };
Animal.hello = function () {
	print(this.name + " says hello");
};
Animal.interact = function (eventDetails) {
	switch (eventDetails.type) {
		case "toy":
		case "animal":
			print(this.name + " interacts with " + eventDetails.description);
			break;
		default:
			return;
	}
};

var Bird = Object.create(Animal);
Bird.name = "Bird";
Bird.fly = function (where) {
	print(this.name + " flies " + where);
};
Bird.interact = function (eventDetails) {
	switch (eventDetails.type) {
		case "seed":
			print(this.name + " eats " + eventDetails.description + " happily");
			break;
		default:
			Animal.interact(eventDetails);
	}
};

// Create object Penguin
var Penguin = Object.create(Bird);
Penguin.name = "Penguin";
Penguin.fly = function (where) {
	print(this.name + " can't fly");
};
Penguin.interact = function (eventDetails) {
	switch (eventDetails.type) {
		case "fish":
			print(this.name + " eats " + eventDetails.description + " greedily");
			break;
		default:
			Bird.interact(eventDetails);
	}
};

// Create function forcedToFly
function forcedToFly(entity) {
	Bird.fly.call(entity, "in the sky");
}

// Please keep the following test cases unmodified
print("0.");
Animal.hello();
Bird.hello();
Bird.fly("in the sky");

print("1.");
Penguin.hello();
Penguin.fly("in the sky");

print("2.");
forcedToFly(Animal);
forcedToFly(Penguin);

print("3. Events:");
Animal.interact({ type: "toy", description: "a bouncing ball" });
Bird.interact({ type: "seed", description: "a handful of sunflower seeds" });
Penguin.interact({ type: "seed", description: "several toxic seeds for penguins" });
Penguin.interact({ type: "animal", description: "a dangerous shark" });
Penguin.interact({ type: "fish", description: "a fresh salmon" });

/*
0.
Animal says hello
Bird says hello
Bird flies in the sky
1.
Penguin says hello
Penguin can't fly
2.
Animal flies in the sky
Penguin flies in the sky
3. Events:
Animal interacts with a bouncing ball
Bird eats a handful of sunflower seeds happily
Penguin eats several toxic seeds for penguins happily
Penguin interacts with a dangerous shark
Penguin eats a fresh salmon greedily
*/
