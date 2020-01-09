import json

blocktypes = ['iron', 'diamond', 'gold', 'redstone', 'emerald', 'coal', 'lapis']

with open('./nether_block.json') as json_file:
	json_data = json.load(json_file)

for blocktype in blocktypes:

	json_data['pools'][0]['entries'][0]['name'] = f'nether_ores:nether_{blocktype}'
	json_data['pools'][0]['rolls'] = 1
	
	with open(f'./nether_{blocktype}.json', 'w+') as outfile:
		json.dump(json_data, outfile)